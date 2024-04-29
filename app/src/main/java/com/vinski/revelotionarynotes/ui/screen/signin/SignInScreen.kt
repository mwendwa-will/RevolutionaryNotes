package com.vinski.revelotionarynotes.ui.screen.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = "Welcome Back", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Sign in with your email or password\nor create a new account.",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(130.dp))
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // Username Field
            OutlinedTextField(
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Password Field
            OutlinedTextField(
                leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Sign In Button
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign In")
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Additional Options (e.g., Sign Up, Forgot Password)
            Text(
                text = "Don't have an account? Sign Up",
                style = TextStyle(color = Color.Black),
                modifier = Modifier.clickable(onClick = { /*TODO*/ })
            )
            Text(
                text = "Forgot Password?",
                style = TextStyle(color = Color.Black   ),
                modifier = Modifier.clickable(onClick = { /*TODO*/ })
            )
        }
    }
}


@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
