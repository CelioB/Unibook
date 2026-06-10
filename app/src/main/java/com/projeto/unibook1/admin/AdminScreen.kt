package com.projeto.unibook1.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.LibraryBooks
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.unibook1.admin.AdminBottomNavBar

// Paleta Padronizada Admin
private val AdminDarkBlue = Color(0xFF2F2C79)
private val AdminBluePrimary = Color(0xFF2196F3)
private val AdminBlueLight = Color(0xFFE8F0FE)
private val BackgroundGray = Color(0xFFF4F6F9)
private val CardWhite = Color(0xFFFFFFFF)
private val TextDark = Color(0xFF1A1A2E)
private val TextGray = Color(0xFF6B7280)

@Composable
fun AdminScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToEmprestimos: () -> Unit = {},
    onNavigateToLivros: () -> Unit = {},
    onManageUsers: () -> Unit = {},
    onManageSystem: () -> Unit = {},
    onViewReports: () -> Unit = {}
) {
    Scaffold(
        containerColor = BackgroundGray,
        bottomBar = {
            AdminBottomNavBar(
                currentRoute = "admin_dashboard",
                onNavigateToHome = onNavigateToHome,
                onNavigateToEmprestimos = onNavigateToEmprestimos,
                onNavigateToLivros = onNavigateToLivros
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 1. Cabeçalho de Boas-vindas
            Column {
                Text(
                    text = "Painel de Controle",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = AdminDarkBlue
                )
                Text(
                    text = "Bem-vindo de volta, Administrador",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextGray
                )
            }

            // 2. Grid de Métricas Rápidas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MetricCard(
                    label = "Usuários Ativos",
                    value = "1.240",
                    icon = Icons.Outlined.People,
                    modifier = Modifier.weight(1f)
                )
                MetricCard(
                    label = "Livros Totais",
                    value = "5.820",
                    icon = Icons.AutoMirrored.Outlined.LibraryBooks,
                    modifier = Modifier.weight(1f)
                )
            }

            // 3. Seção de Gestão
            Text(
                text = "GESTÃO DO SISTEMA",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 1.sp
            )

            ManagementCard(
                title = "Gerenciar Usuários",
                subtitle = "Bloqueios, permissões e novos cadastros",
                icon = Icons.Default.ManageAccounts,
                onClick = onManageUsers
            )

            ManagementCard(
                title = "Configurações da Biblioteca",
                subtitle = "Prazos, multas e horários de funcionamento",
                icon = Icons.Default.Settings,
                onClick = onManageSystem
            )

            ManagementCard(
                title = "Relatórios e Estatísticas",
                subtitle = "Análise de fluxo e livros mais lidos",
                icon = Icons.Default.Assessment,
                onClick = onViewReports
            )

            // 4. Status do Servidor
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = AdminBlueLight.copy(alpha = 0.5f)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4CAF50))
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Sistema Operacional - Sincronizado com Nuvem",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = AdminDarkBlue
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun MetricCard(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AdminBlueLight),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = AdminDarkBlue,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(text = label, fontSize = 11.sp, color = TextGray, fontWeight = FontWeight.SemiBold)
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = TextDark)
        }
    }
}

@Composable
private fun ManagementCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(AdminBlueLight),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = AdminDarkBlue,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TextDark)
                Text(text = subtitle, fontSize = 12.sp, color = TextGray)
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = TextGray.copy(alpha = 0.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminDashboardPreview() {
    AdminScreen()
}
