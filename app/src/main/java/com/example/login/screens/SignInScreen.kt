package com.example.login.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.User


@Composable
fun SingInScreen(
    onSignInClick:(User) -> Unit
) {
    Column {

        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = username,
            onValueChange = { newValue ->
                username = newValue
            },
            label = {
                Text(text = "Usuário")
            },
            //Icones que ficam na esquerda
            leadingIcon = @Composable {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "usuário"
                )
            }
        )
        TextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text(text = "Entrar")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = "Representação de senha "
                )
            }

        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(Color.Blue.value)
            ),
            onClick = {
                onSignInClick(
                    User(
                        username,
                        password
                    )
                )
            })
        {
            Text(text = "Entrar")
        }
        val mainButtonColor = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.surface
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = mainButtonColor,
            onClick = {
                onSignInClick(
                    User(
                        username,
                        password
                    )
                )
            })
        {
            Text(
                text = "Cadastrar",
                color = Color.Blue
            )
            Color(Color.White.value)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AuthScreenView() {
    SingInScreen{}
}