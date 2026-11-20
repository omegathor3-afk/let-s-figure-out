package com.omega.autoearn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF10151D)
private val Panel = Color(0xFF1B2430)
private val Mint = Color(0xFF55D6A5)
private val Muted = Color(0xFF9AA8B8)

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
    var started by remember { mutableStateOf(false) }
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Mint, background = Ink, surface = Panel,
        onPrimary = Ink, onBackground = Color.White, onSurface = Color.White
    )) {
        Surface(Modifier.fillMaxSize(), color = Ink) {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(22.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Text("AUTOEARN", color = Mint, fontSize = 13.sp, fontWeight = FontWeight.Bold, letterSpacing = 3.sp)
                Text("مساعد الدخل التلقائي", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("لوحة واحدة لتشغيل ومتابعة مصادر الدخل التي توافق عليها.", color = Muted, fontSize = 14.sp)
                Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(22.dp)) {
                    Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text("مصدر الدخل الأول", color = Muted, fontSize = 13.sp)
                        Text("Honeygain", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Text("مشاركة جزء من اتصال الإنترنت غير المستخدم مقابل رصيد. العائد يعتمد على الطلب على عنوان IP وحجم الاستخدام؛ لا يوجد دخل مضمون.", color = Muted, fontSize = 14.sp)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("الحالة", color = Muted)
                            Spacer(Modifier.width(10.dp))
                            Text(if (started) "تم فتح صفحة الخدمة — يلزم إعداد الحساب داخلها" else "غير مفعّل", color = if (started) Mint else Color(0xFFFFC36B), fontWeight = FontWeight.SemiBold)
                        }
                        Button(
                            onClick = {
                                disclosure = true
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Mint),
                            shape = RoundedCornerShape(14.dp)
                        ) { Text("ابدأ الإعداد", fontWeight = FontWeight.Bold) }
                    }
                }
                Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(22.dp)) {
                    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                        Text("شروط مهمة قبل التشغيل", fontWeight = FontWeight.Bold)
                        Bullet("Honeygain يستخدم اتصالك وعنوان IP الخاص بك كوسيط لطلبات عملائه.")
                        Bullet("الشروط الرسمية تحذر من احتمال مخالفة شروط مزود الإنترنت أو استهلاك باقة البيانات.")
                        Bullet("الحد المعتاد للسحب 20 دولارًا عبر PayPal. وضع JumpTask: حد أول سحب 1 دولار ثم 0.50 دولار، عبر وسائل GIFQ المتاحة لبلدك.")
                        Bullet("لا يدعم السحب المباشر إلى Vodafone Cash حسب وسائل الدفع المنشورة.")
                    }
                }
                Text("الشفافية: التطبيق لا يقرأ رصيد Honeygain ولا يستطيع تشغيله أو تسجيل الدخول نيابةً عنك. لن يعرض أرباحًا وهمية. بعد تثبيت الخدمة وتسجيل الدخول والموافقة على شروطها، يمكنها العمل في الخلفية وفق إعدادات أندرويد.", color = Muted, fontSize = 12.sp)
                if (disclosure) {
                    AlertDialog(
                        onDismissRequest = { disclosure = false },
                        title = { Text("موافقة واعية قبل مشاركة الإنترنت") },
                        text = { Text("ستشارك حركة بيانات عبر عنوان IP الخاص بك مع عملاء Honeygain. قد يؤثر ذلك على استهلاك البيانات أو شروط مزود الخدمة، وقد لا يتوفر طلب كافٍ في مصر. هل تريد فتح الموقع الرسمي وقراءة الشروط؟") },
                        confirmButton = {
                            TextButton(onClick = {
                                disclosure = false
                                started = true
                                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.honeygain.com/download/")))
                            }) { Text("فتح الموقع الرسمي") }
                        },
                        dismissButton = { TextButton(onClick = { disclosure = false }) { Text("إلغاء") } }
                    )
                }
                Text("الإصدار 0.1.0 • لا توجد أتمتة خفية أو نقرات مدفوعة وهمية", color = Muted, fontSize = 11.sp)
            }
        }
    }
}

@Composable
private fun Bullet(text: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("•", color = Mint, fontWeight = FontWeight.Bold)
        Text(text, color = Muted, fontSize = 13.sp)
    }
}
