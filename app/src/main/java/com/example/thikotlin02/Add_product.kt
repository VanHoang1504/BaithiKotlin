package com.example.thikotlin02

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController


@Composable
fun Add_product(viewmodel: XeHoi_Viewmodel, navController: NavController) {
    var name_PH42448 by remember { mutableStateOf("") }
    var price_PH42448 by remember { mutableStateOf("") }
    var model_PH42448 by remember { mutableStateOf("") }
    var status by remember { mutableStateOf(false) }
    var img by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color("#f0f0f0".toColorInt()))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name_PH42448,
            onValueChange = { name_PH42448 = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Name_PH42448") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = price_PH42448,
            onValueChange = { price_PH42448 = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Price_PH42448") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = model_PH42448,
            onValueChange = { model_PH42448 = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "model_PH42448") })
        TextField(
            value = img,
            onValueChange = { img = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Image") })
        Button(onClick = {
            try {
                if (name_PH42448.isNotEmpty() && price_PH42448.isNotEmpty() && model_PH42448.isNotEmpty()) {
                    var newProduct = XeHoi(
                        name = name_PH42448,
                        price = price_PH42448,
                        model = model_PH42448,
                        status = status,
                        id = "",
                        img = img
                    )
                    if (newProduct != null) {
                        viewmodel.addProduct(newProduct)
                        Toast.makeText(context, "Da them $name_PH42448", Toast.LENGTH_SHORT).show()
                        navController.navigate(Route.Home)
                    }
                }else{
                    Toast.makeText(context, "Khong de trong du lieu", Toast.LENGTH_SHORT).show()
                }
            }catch (e:Exception){
                Log.d("Error",e.message.toString())
            }
        }) {
            Text(text = "ADD")
        }
    }
}
