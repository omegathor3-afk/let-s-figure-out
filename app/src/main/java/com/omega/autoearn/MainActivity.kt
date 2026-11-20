package com.omega.autoearn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowOutward
import androidx.compose.material.icons.rounded.Hive
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.WifiTethering
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext

private val Night = Color(0xFF10100E)
private val SurfaceDark = Color(0xFF1D1B16)
private val SurfaceRaised = Color(0xFF28241B)
private val Honey = Color(0xFFFFC247)
private val HoneySoft = Color(0xFFFFD982)
private val Cream = Color(0xFFF8F0DE)
private val Ash = Color(0xFFB9B09F)
private val Olive = Color(0xFF9AA66A)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AutoEarnScreen() }
    }
}

@Composable
fun AutoEarnScreen() {
    val context = LocalContext.current
    var disclosure by remember { mutableStateOf(false) }
    var opened by remember { mutableStateOf(false) }
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Honey, onPrimary = Night, background = Night,
        surface = SurfaceDark, onBackground = Cream, onSurface = Cream
    )) {
        Surface(Modifier.fillMaxSize(), color = Night) {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp, vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(Modifier.size(48.dp).background(Honey, RoundedCornerShape(16.dp)), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Hive, contentDescription = null, tint = Night, modifier = Modifier.size(30.dp))
                    }
                    Column {
                        Text("AUTOEARN", color = Honey, fontSize = 13.sp, fontWeight = FontWeight.Black, letterSpacing = 2.8.sp)
                        Text("مساعد الدخل الذكي", color = Cream, fontSize = 12.sp)
                    }
                    Spacer(Modifier.weight(1f))
                    Box(Modifier.border(1.dp, Honey.copy(alpha = .35f), CircleShape).padding(horizontal = 11.dp, vertical = 6.dp)) {
                        Text("BETA  •  0.2", color = HoneySoft, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Text("خلّي اتصالك
يشتغل بذكاء.", color = Cream, fontSize = 31.sp, lineHeight = 37.sp, fontWeight = FontWeight.ExtraBold)
                    Text("تابع مصادر الدخل المسموح بها من مكان واحد، بوضوح وتحكّم.", color = Ash, fontSize = 14.sp, lineHeight = 21.sp)
                }

                Card(
                    colors = CardDefaults.cardColors(containerColor = SurfaceRaised),
                    shape = RoundedCornerShape(26.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Honey.copy(alpha = .23f))
                ) {
                    Column(Modifier.padding(19.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier.size(43.dp).background(Honey.copy(alpha = .14f), RoundedCornerShape(14.dp)), contentAlignment = Alignment.Center) {
                                Icon(Icons.Rounded.WifiTethering, contentDescription = null, tint = Honey, modifier = Modifier.size(25.dp))
                            }
                            Spacer(Modifier.width(11.dp))
                            Column(Modifier.weight(1f)) {
                                Text("مصدر دخل محتمل", color = Ash, fontSize = 11.sp)
                                Text("Honeygain", color = Cream, fontSize = 21.sp, fontWeight = FontWeight.Bold)
                            }
                            Box(Modifier.background(Olive.copy(alpha = .16f), CircleShape).padding(horizontal = 10.dp, vertical = 6.dp)) {
                                Text("اختياري", color = Olive, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Text("مشاركة جزء من اتصال الإنترنت غير المستخدم مقابل رصيد. العائد يتغير حسب الطلب على عنوان IP وحجم الاستخدام، ولا يوجد دخل مضمون.", color = Ash, fontSize = 13.sp, lineHeight = 20.sp)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier.size(7.dp).background(if (opened) Olive else Honey, CircleShape))
                            Spacer(Modifier.width(8.dp))
                            Text(if (opened) "تم فتح الموقع — أكمل الإعداد هناك" else "لم يتم إعداد الخدمة بعد", color = if (opened) Olive else HoneySoft, fontSize = 11.sp)
                        }
                        Button(
                            onClick = { disclosure = true },
                            modifier = Modifier.fillMaxWidth().height(52.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Honey, contentColor = Night),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("إعداد Honeygain", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                            Spacer(Modifier.width(8.dp))
                            Icon(Icons.Rounded.ArrowOutward, contentDescription = null, modifier = Modifier.size(17.dp))
                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                    Icon(Icons.Rounded.Security, contentDescription = null, tint = Honey, modifier = Modifier.size(20.dp))
                    Text("قبل ما تبدأ، اعرف التفاصيل", color = Cream, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Card(colors = CardDefaults.cardColors(containerColor = SurfaceDark), shape = RoundedCornerShape(20.dp)) {
                    Column(Modifier.padding(17.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        InfoLine("اتصالك وعنوان IP قد يُستخدمان لتمرير طلبات عملاء الخدمة.")
                        InfoLine("قد يزيد استهلاك البيانات، وقد تتعارض الخدمة مع شروط مزود الإنترنت.")
                        InfoLine("السحب ووسائله وحدوده تعتمد على بلدك وحسابك؛ لا يوجد ضمان لتوفر Vodafone Cash.")
                        InfoLine("لا تشغّل مشاركة الإنترنت إلا على شبكة تملك حق استخدامها وبعد قراءة الشروط.")
                    }
                }
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                    Icon(Icons.Rounded.Info, contentDescription = null, tint = HoneySoft, modifier = Modifier.size(18.dp))
                    Text("بشفافية: AUTOEARN حاليًا واجهة مساعدة تفتح الموقع الرسمي فقط. لا يقرأ الرصيد، ولا يسجّل الدخول أو يشغّل Honeygain تلقائيًا، ولا ينشئ أرباحًا وهمية.", color = Ash, fontSize = 11.sp, lineHeight = 17.sp)
                }
                Text("صُنع بعناية • AUTOEARN", color = Color(0xFF746B5B), fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(Modifier.height(8.dp))
            }
        }
    }
    if (disclosure) {
        AlertDialog(
            onDismissRequest = { disclosure = false },
            containerColor = SurfaceRaised,
            titleContentColor = Cream,
            textContentColor = Ash,
            title = { Text("موافقة واعية قبل مشاركة الإنترنت") },
            text = { Text("قد تمر حركة بيانات عبر عنوان IP الخاص بك لصالح عملاء Honeygain. راجع استهلاك البيانات وشروط مزود الخدمة وسياسة الخصوصية. هل تريد فتح الموقع الرسمي؟") },
            confirmButton = {
                TextButton(onClick = {
                    disclosure = false
                    opened = true
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.honeygain.com/download/")))
                }) { Text("فتح الموقع", color = Honey, fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { disclosure = false }) { Text("رجوع", color = Ash) } }
        )
    }
}

@Composable
private fun InfoLine(value: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(9.dp), verticalAlignment = Alignment.Top) {
        Box(Modifier.padding(top = 5.dp).size(6.dp).background(Honey, CircleShape))
        Text(value, color = Ash, fontSize = 12.sp, lineHeight = 18.sp)
    }
}
