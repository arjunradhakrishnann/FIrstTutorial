package contactapp.practice.arjun.contactapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<DataModel> dataModelArrayList;

    public RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView fname,lname,email,phone;

        public Myholder(View itemView) {
            super(itemView);

            fname = (TextView) itemView.findViewById(R.id.fname);
            lname= (TextView) itemView.findViewById(R.id.lname);
            email= (TextView) itemView.findViewById(R.id.email);
            phone=(TextView)itemView.findViewById(R.id.phone);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.fname.setText(dataModel.getFname());
        holder.lname.setText(dataModel.getLname());
        holder.email.setText(dataModel.getEmail());
        holder.phone.setText(dataModel.getPhone());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}