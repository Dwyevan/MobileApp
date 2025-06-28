package com.example.mobieapphnd.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobieapphnd.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupRecyclerView();
        loadProducts();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        getSupportActionBar().setTitle("Sản phẩm");
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList, new ProductAdapter.OnProductClickListener() {
            @Override
            public void onProductItemClick(Product product) {

            }

            @Override
            public void onProductClick(Product product) {
                Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
                intent.putExtra("product", product);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts() {
        // Dữ liệu mẫu - trong thực tế sẽ load từ API hoặc database
    //Điện Thoại
        productList.add(new Product(1, "iPhone 14", "Điện thoại thông minh cao cấp", 25000000,R.drawable.ip14));
        productList.add(new Product(2, "Samsung Galaxy S23", "Flagship Android tốt nhất", 22000000,R.drawable.samsung));
        productList.add(new Product(7, "Google Pixel 7", "Điện thoại Google với camera xuất sắc", 18000000, R.drawable.pixel7));
        productList.add(new Product(9, "Xiaomi Mi 11", "Flagship của Xiaomi với cấu hình mạnh", 15000000, R.drawable.xiaomi));
    // Laptop
        productList.add(new Product(3, "MacBook Air M2", "Laptop siêu mỏng và mạnh mẽ", 35000000,R.drawable.macbook));
        productList.add(new Product(10, "Dell XPS 13", "Ultrabook siêu mỏng, hiệu năng cao", 30000000, R.drawable.dell));
     // Máy tính bảng
        productList.add(new Product(4, "iPad Pro", "Máy tính bảng chuyên nghiệp", 28000000,R.drawable.ipad));
    // Tai Nghe
        productList.add(new Product(5, "AirPods Pro", "Tai nghe không dây chống ồn", 6000000,R.drawable.airpod));
        productList.add(new Product(8, "Sony WH-1000XM5", "Tai nghe chống ồn hàng đầu của Sony", 8000000, R.drawable.sony));
    // Đồng Hồ Thông Minh
        productList.add(new Product(6, "Apple Watch", "Đồng hồ thông minh", 9000000,R.drawable.watch ));
        //Loa
        productList.add(new Product(11, "Amazon Echo Dot", "Loa thông minh điều khiển bằng giọng nói", 1200000, R.drawable.loa));

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        prefs.edit().putBoolean("is_logged_in", false).apply();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}