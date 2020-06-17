package in.lavit.drawabledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageAdapter adapter;
    private ArrayList<Images> imagesArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesArrayList = new ArrayList<>();
        Images images = new Images();
        images.setImageId(R.drawable.androidpi);
        images.setImageName("Android Pi");
        imagesArrayList.add(images);

        Images images1 = new Images();
        images1.setImageId(R.drawable.froyo);
        images1.setImageName("Froyo");
        imagesArrayList.add(images1);

        Images images2 = new Images();
        images2.setImageId(R.drawable.gengerbread);
        images2.setImageName("Genger Bread");
        imagesArrayList.add(images2);

        Images images3 = new Images();
        images3.setImageId(R.drawable.honeycomb);
        images3.setImageName("Honey Compb");
        imagesArrayList.add(images3);

        adapter = new ImageAdapter(this,imagesArrayList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
