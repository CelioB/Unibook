package com.projeto.unibook1.telasgerais

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.unibook1.ui.theme.Unibook1Theme

// ── Color palette (Consistent with LivrosMain/Insight) ────────────────────────
private val AzureBlue = Color(0xFF1565C0)
private val ButtonBlue = Color(0xFF1A73E8)
private val CardBg = Color.White
private val DividerColor = Color(0xFFEEEEEE)
private val SuccessGreen = Color(0xFF4CAF50)
private val ErrorRed = Color(0xFFE53935)
private val TextPrimary = Color(0xFF1A1A1A)
private val TextSecondary = Color(0xFF666666)

enum class ReservaStep {
    LISTA_PENDENCIAS,
    APROVAR_PEDIDO,
    QR_CODE_GERADO,
    ESCANEAR_QR,
    SUCESSO,
    ERRO
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaReservaArmario() {
    var currentStep by remember { mutableStateOf(ReservaStep.LISTA_PENDENCIAS) }
    var selectedStudent by remember { mutableStateOf("João Silva") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reserva de Armário", fontWeight = FontWeight.Bold, color = AzureBlue) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF6F6F9))
        ) {
            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "step_transition"
            ) { step ->
                when (step) {
                    ReservaStep.LISTA_PENDENCIAS -> ListaPendenciasView { 
                        selectedStudent = it
                        currentStep = ReservaStep.APROVAR_PEDIDO 
                    }
                    ReservaStep.APROVAR_PEDIDO -> AprovarPedidoView(
                        studentName = selectedStudent,
                        onApprove = { currentStep = ReservaStep.QR_CODE_GERADO },
                        onBack = { currentStep = ReservaStep.LISTA_PENDENCIAS }
                    )
                    ReservaStep.QR_CODE_GERADO -> QrCodeGeradoView(
                        onScanSimulated = { currentStep = ReservaStep.ESCANEAR_QR }
                    )
                    ReservaStep.ESCANEAR_QR -> EscanearQrView(
                        onAccept = { currentStep = ReservaStep.SUCESSO },
                        onReject = { currentStep = ReservaStep.ERRO }
                    )
                    ReservaStep.SUCESSO -> ResultadoView(
                        isSuccess = true,
                        onReset = { currentStep = ReservaStep.LISTA_PENDENCIAS }
                    )
                    ReservaStep.ERRO -> ResultadoView(
                        isSuccess = false,
                        onReset = { currentStep = ReservaStep.LISTA_PENDENCIAS }
                    )
                }
            }
        }
    }
}

@Composable
fun ListaPendenciasView(onSelect: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Solicitações Pendentes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        val pendencias = listOf("João Silva", "Maria Oliveira", "Pedro Santos")
        pendencias.forEach { nome ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onSelect(nome) },
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(AzureBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(nome.take(1), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = nome, fontWeight = FontWeight.Bold)
                        Text(text = "Solicitado em: 25/05/2024", fontSize = 12.sp, color = TextSecondary)
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = TextSecondary)
                }
            }
        }
    }
}

@Composable
fun AprovarPedidoView(studentName: String, onApprove: () -> Unit, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.AutoMirrored.Filled.HelpOutline, contentDescription = null, tint = AzureBlue, modifier = Modifier.size(64.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Aprovar pedido de reserva?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Aluno: $studentName\nArmário: Bloco A - Térreo",
            textAlign = TextAlign.Center,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onApprove,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonBlue),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Sim, Gerar QR Code")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Não, Voltar")
        }
    }
}

@Composable
fun QrCodeGeradoView(onScanSimulated: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "QR Code Gerado",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AzureBlue
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.White)
                .border(2.dp, DividerColor, RoundedCornerShape(8.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.QrCode2, contentDescription = null, modifier = Modifier.fillMaxSize(), tint = Color.Black)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Apresente este código para o aluno escanear no armário.",
            textAlign = TextAlign.Center,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onScanSimulated,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonBlue),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Simular Escaneamento")
        }
    }
}

@Composable
fun EscanearQrView(onAccept: () -> Unit, onReject: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Escaneando QR Code...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(250.dp)
                .border(4.dp, AzureBlue, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.QrCodeScanner, contentDescription = null, modifier = Modifier.size(100.dp), tint = AzureBlue,)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Aceitar pedido escaneado?", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = onAccept,
                modifier = Modifier.weight(1f).height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Sim")
            }
            Button(
                onClick = onReject,
                modifier = Modifier.weight(1f).height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ErrorRed),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Não")
            }
        }
    }
}

@Composable
fun ResultadoView(isSuccess: Boolean, onReset: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (isSuccess) Icons.Default.CheckCircle else Icons.Default.Error,
            contentDescription = null,
            tint = if (isSuccess) SuccessGreen else ErrorRed,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = if (isSuccess) "Empréstimo Registrado!" else "Erro na Solicitação",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = if (isSuccess) 
                "O armário foi reservado com sucesso no banco de dados." 
                else "Não foi possível validar o QR Code ou o pedido foi negado.",
            textAlign = TextAlign.Center,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onReset,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AzureBlue),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Voltar ao Início")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaReservaArmarioPreview() {
    Unibook1Theme {
        TelaReservaArmario()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors()
) {
    CenterAlignedTopAppBar(
        title = title,
        colors = colors
    )
}
