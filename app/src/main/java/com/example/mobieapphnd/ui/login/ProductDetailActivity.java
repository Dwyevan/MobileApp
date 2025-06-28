package com.example.mobieapphnd.ui.login;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobieapphnd.R;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView ivProduct;
    private TextView tvName, tvDescription, tvPrice;
    private Button btnAddToCart;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Lấy product từ Intent
        product = (Product) getIntent().getSerializableExtra("product");

        if (product == null) {
            finish();
            return;
        }

        initViews();
        displayProductInfo();
        setupClickListeners();
    }

    private void initViews() {
        ivProduct = findViewById(R.id.iv_product);
        tvName = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_description);
        tvPrice = findViewById(R.id.tv_price);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        // Hiển thị nút back trên ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi tiết sản phẩm");
    }

    private void displayProductInfo() {
        tvName.setText(product.getName());
        tvDescription.setText(product.getDescription());

        // Format giá tiền
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        tvPrice.setText(formatter.format(product.getPrice()));

        // Trong thực tế, bạn sẽ dùng thư viện như Glide hoặc Picasso để load ảnh
        // Glide.with(this).load(product.getImageUrl()).into(ivProduct);

        // Tạm thời set ảnh mặc định
        ivProduct.setImageResource(product.getImageResId());


    }

    private void setupClickListeners() {
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });
    }

    private void addToCart() {
        // Logic thêm sản phẩm vào giỏ hàng
        // Trong thực tế sẽ lưu vào database hoặc gửi lên server
        Toast.makeText(this, "Đã thêm " + product.getName() + " vào giỏ hàng!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}