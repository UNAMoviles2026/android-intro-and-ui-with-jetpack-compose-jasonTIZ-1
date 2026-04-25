package com.moviles.unaroom.ui.screens.login

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import com.moviles.unaroom.R
import com.moviles.unaroom.ui.components.AppButton
import com.moviles.unaroom.ui.components.AppTextField
import com.moviles.unaroom.ui.theme.UnaRoomTheme

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isEmailValid = remember(email) { Patterns.EMAIL_ADDRESS.matcher(email).matches() }
    val isPasswordValid = password.length >= 6
    val isFormValid = isEmailValid && isPasswordValid

    val emailError = if (email.isNotBlank() && !isEmailValid) {
        stringResource(id = R.string.login_email_error)
    } else {
        null
    }

    val passwordError = if (password.isNotBlank() && !isPasswordValid) {
        stringResource(id = R.string.login_password_error)
    } else {
        null
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login_title),
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = stringResource(id = R.string.login_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            value = email,
            label = stringResource(id = R.string.login_email_label),
            onValueChange = { email = it.trim() },
            modifier = Modifier.fillMaxWidth(),
            isError = emailError != null,
            supportingText = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        AppTextField(
            value = password,
            label = stringResource(id = R.string.login_password_label),
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError != null,
            supportingText = passwordError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        AppButton(
            text = stringResource(id = R.string.login_button),
            onClick = {
                if (isFormValid) {
                    onLoginClick()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isFormValid
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    UnaRoomTheme {
        LoginScreen(onLoginClick = {})
    }
}

