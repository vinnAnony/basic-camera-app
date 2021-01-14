package com.v.aidetect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeView> {

    private List<Integer> imageList = new ArrayList<>();
    private List<String> imageDescriptionList = new ArrayList<>();
    Context mContext;
    private ProgressDialog pDialog;

    public HomeAdapter(List<Integer> imageList, List<String> imageDescriptionList) {
        this.imageList = imageList;
        this.imageDescriptionList = imageDescriptionList;
    }

    //before passing anything create a view class
    //finally implement methods

    @NonNull
    @Override
    public HomeView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //pass the layout resource file ie row_home
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card,parent,false);

        mContext = parent.getContext();

        return  new HomeView(view);//pass the object we created

    }

    @Override
    public void onBindViewHolder(@NonNull final HomeView holder, final int position) {

        //passing values
        holder.image.setImageResource(imageList.get(position));
        holder.imageDescr.setText(imageDescriptionList.get(position));

        holder.hCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String page = imageDescriptionList.get(position);

                if (page.equals(mContext.getResources().getString(R.string.corn))){
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.corn), Toast.LENGTH_SHORT).show();
                    holder.openCam();
                }
                if (page.equals(mContext.getResources().getString(R.string.apple))){
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.apple), Toast.LENGTH_SHORT).show();
                    holder.openCam();
                }
                if (page.equals(mContext.getResources().getString(R.string.tomato))){
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.tomato), Toast.LENGTH_SHORT).show();
                    holder.openCam();
                }
                if (page.equals(mContext.getResources().getString(R.string.potato))){
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.potato), Toast.LENGTH_SHORT).show();
                    holder.openCam();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    //before passing anything create a view class
    public class HomeView extends RecyclerView.ViewHolder{
        ImageView image;
        TextView imageDescr;
        CardView hCV;
        //create constructor of that view
        public HomeView(@NonNull View itemView) {
            super(itemView);

            imageDescr = itemView.findViewById(R.id.imageDescription);
            image = itemView.findViewById(R.id.image);
            hCV = itemView.findViewById(R.id.homeCardV);
        }

        private void displayLoader() {
            pDialog = new ProgressDialog(mContext);
            pDialog.setMessage("Logging out...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        private void openCam(){
            mContext.startActivity(new Intent(mContext,MainActivity.class));
        }

    }
}
