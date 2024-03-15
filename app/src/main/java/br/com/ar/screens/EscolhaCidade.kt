import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnrememberedMutableState")
@Composable
fun EscolhaCidade() {
    val entradaCidade = mutableStateOf(TextFieldValue())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14CCED))
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Digite o nome da cidade:",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
        ) {
            BasicTextField(
                value = entradaCidade.value,
                onValueChange = { entradaCidade.value = it },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterStart)
            )
        }

        // Bloco para informações sobre a qualidade do ar
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Qualidade do Ar:",
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "Boa", // Aqui você pode adicionar a informação real da qualidade do ar
                fontSize = 18.sp,
                color = Color.White
            )
        }

        // Bloco para informações sobre a temperatura
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Temperatura:",
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "25°C", // Aqui você pode adicionar a informação real da temperatura
                fontSize = 18.sp,
                color = Color.White
            )
        }

        // Adicionar ícones representativos do clima, como ensolarado, chuvoso, etc.

    }
}
