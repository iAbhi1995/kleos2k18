package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.adapters;




import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.activities.QuestionActivity;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.models.Question;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.restapi.ApiBase;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.restapi.ApiEndpoints;
import com.wang.avi.AVLoadingIndicatorView;

import am.appwise.components.ni.NoInternetDialog;
import es.dmoral.toasty.Toasty;
import io.github.mthli.slice.Slice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionRecyclerAdapter extends RecyclerView.Adapter<QuestionRecyclerAdapter.QuestionViewHolder>{
    //ArrayList<Question> questions = new ArrayList<Question>();
    Context ct;
    String level;


    public QuestionRecyclerAdapter(Context ct, String level){
        this.ct = ct;
        this.level = level;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(ct);
        View MyOwnView = myInflator.inflate(R.layout.question_card,parent,false);
        return new QuestionViewHolder(MyOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Slice slice = new Slice(holder.questionCard);
        slice.setRipple(1);
        slice.setRadius(8.0f);
        holder.avi.show();
        holder.questionTextView.setVisibility(View.INVISIBLE);
        holder.questionContent.setVisibility(View.INVISIBLE);
        holder.bookmark.setVisibility(View.INVISIBLE);

        ApiEndpoints apiBase = ApiBase.getClient().create(ApiEndpoints.class);
        Call<Question> call = apiBase.getQuestionbyId(String.valueOf(position + 1));
        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(@NonNull Call<Question> call, @NonNull Response<Question> response) {
                if(response.isSuccessful()){
                    holder.avi.hide();
                    holder.questionTextView.setVisibility(View.VISIBLE);
                    holder.questionContent.setVisibility(View.VISIBLE);
                    if(!response.body().question.toString().equals("")){
                        if(Integer.parseInt(level)>position){
                            holder.bookmark.setVisibility(View.VISIBLE);
                        }
                        holder.questionTextView.setText(response.body().title);
                        holder.questionContent.setText(response.body().question);
                        holder.questionCard.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(ct, QuestionActivity.class);
                                i.putExtra("question",response.body());
                                i.putExtra("id",position+1);
                                ct.startActivity(i);
                            }
                        });
                    }else {
                        Toasty.error(ct, "Some Thing Went Wrong", Toast.LENGTH_SHORT, true).show();
                    }
                }
                else{
                    Toasty.error(ct, "Some Thing Went Wrong", Toast.LENGTH_SHORT, true).show();
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(ct).build();

            }
        });



    }

    @Override
    public int getItemCount() {
        if(Integer.parseInt(level) == 12)
        return 12;
        else return Integer.parseInt(level)+1;

    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        TextView questionTextView, questionContent;
        ConstraintLayout questionCard;
        ImageView bookmark;
        AVLoadingIndicatorView avi;
        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionCard = itemView.findViewById(R.id.questionCard);
            avi = itemView.findViewById(R.id.avi);
            questionTextView = itemView.findViewById(R.id.questionTitle);
            questionContent = itemView.findViewById(R.id.questionContent);
            bookmark = itemView.findViewById(R.id.bookmark);
        }




    }

}
