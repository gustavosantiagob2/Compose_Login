package com.example.login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthScreen(
                        onEnterClick = {
                            Log.i("MainActivity","onCreate $it")
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun AuthScreen(
    onEnterClick:(User) -> Unit
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
            leadingIcon = @androidx.compose.runtime.Composable {
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
            onClick = {
                onEnterClick(
                    User(
                        username,
                        password
                    )
                )
            })
        {
            Text(text = "Entrar")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AuthScreenView() {
    AuthScreen(onEnterClick = {})
}