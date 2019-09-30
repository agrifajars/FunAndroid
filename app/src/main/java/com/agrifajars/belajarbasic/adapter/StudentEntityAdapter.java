package com.agrifajars.belajarbasic.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.agrifajars.belajarbasic.R;
import com.agrifajars.belajarbasic.activity.student.add.AddStudentActivity;
import com.agrifajars.belajarbasic.database.DataHelper;
import com.agrifajars.belajarbasic.database.query.StudentDao;
import com.agrifajars.belajarbasic.database.table.StudentEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentEntityAdapter extends RecyclerView.Adapter<StudentEntityAdapter.ViewHolder>{
    private List<StudentEntity> list;
    private Context context;
    private DataHelper dataHelper;

    private StudentEntity studentEntity;
    private StudentDao studentDao;
    private String DB_NAME = "school";

     public StudentEntityAdapter(Context context, List<StudentEntity> list) {
        this.context = context;
        this.list = list;
        dataHelper = Room.databaseBuilder(context, DataHelper.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }
//
//    public StudentEntityAdapter(List<StudentEntity> select) {
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_entity_student, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNis.setText(list.get(position).getNis());
        holder.tvName.setText(list.get(position).getName());
        holder.linearListEntity.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Konfirmasi")
                        .setMessage("Apakah Anda yakin akan menghapus data ini?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataHelper.studentDao().delete(list.get(position));
                                list.remove(list.get(position));
                                notifyItemRemoved(position);
                                notifyItemRangeRemoved(position, getItemCount() - 1);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                return false;
            }
        });
        holder.linearListEntity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddStudentActivity.class);
                i.putExtra("datas", list.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//
//    @Override
//    public Filter getFilter() {
//        return exampleFilter;
//    }
//
//    private Filter exampleFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<List> filteredList = new ArrayList<>(list);
//
//            if (constraint == null || constraint.length() == 0){
//                filteredList.addAll(listFull);
//            } else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//
//                for (List item : listFull) {
//                     if (item.getName().toLowerCase().contains(filterPattern)){
//                         filteredList.add(item);
//                     }
//                }
//            }
//
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            list.clear();
//            list.addAll((List)results.values);
//            notifyDataSetChanged();
//        }
//    };


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNis)
        TextView tvNis;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.linearListEntity)
        LinearLayout linearListEntity;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
