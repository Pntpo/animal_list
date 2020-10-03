package th.ac.su.cp.animal_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.animal_list.animal_Model.animalList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAdapter adapter = new MyAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        RecyclerView rv = findViewById(R.id.word_animal_list_recycler_view);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
     animalList[] items = {
            new animalList(R.drawable.ant, "ANT", "มด"),
            new animalList(R.drawable.bird, "BIRD", "นก"),
            new animalList(R.drawable.cat, "CAT", "แมว"),
            new animalList(R.drawable.dog, "DOG", "สุนัจ"),
            new animalList(R.drawable.duck, "DUCK", "เป็ด"),
            new animalList(R.drawable.lion, "LION", "สิงโต"),
            new animalList(R.drawable.pig, "PIG", "หมู"),
            new animalList(R.drawable.tiger, "TIGER", "เสือ"),
            new animalList(R.drawable.turtle, "TURTLE", "เต่า"),
            new animalList(R.drawable.whale, "WHALE", "วาฬ")
    };
    public MyAdapter() {
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_word__list__animal, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.engName.setText(items[position].main);
        holder.thName.setText(items[position].sub);
    }
    @Override
    public int getItemCount() {
        return items.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView engName;
        TextView thName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            engName = itemView.findViewById(R.id.engName_text_view);
            thName = itemView.findViewById(R.id.thName_text_view);
        }
    }
}
