package in.lavit.drawabledemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Images> imagesArrayList;

    public ImageAdapter(Context context, ArrayList<Images> imagesArrayList) {
        this.context = context;
        this.imagesArrayList = imagesArrayList;
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.image_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageAdapter.MyViewHolder holder, int position) {
        Images images = imagesArrayList.get(position);
        holder.imageView.setImageResource(images.getImageId());
        holder.textView.setText(images.getImageName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setBackground(context.getResources().getDrawable(R.drawable.mybuttonback));
    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
