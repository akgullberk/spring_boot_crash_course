# Spring Boot Crash Course

Bu proje, Spring Boot ve Kotlin kullanılarak geliştirilmiş bir REST API uygulamasıdır. JWT tabanlı kimlik doğrulama ve MongoDB veritabanı kullanılarak not alma uygulaması olarak tasarlanmıştır.

## 📁 Proje Yapısı

```
spring_boot_crash_course/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── spring_boot_crash_course/
│   │   │               ├── controllers/           # API endpoint'leri
│   │   │               │   ├── AuthController.kt  # Kimlik doğrulama işlemleri
│   │   │               │   ├── NoteController.kt  # Not işlemleri
│   │   │               │   └── StatusController.kt # Durum kontrolü
│   │   │               ├── database/
│   │   │               │   ├── model/            # Veritabanı modelleri
│   │   │               │   │   ├── Note.kt       # Not modeli
│   │   │               │   │   ├── User.kt       # Kullanıcı modeli
│   │   │               │   │   └── RefreshToken.kt # Yenileme token modeli
│   │   │               │   └── repository/       # Veritabanı repository'leri
│   │   │               ├── security/             # Güvenlik yapılandırması
│   │   │               │   ├── AuthService.kt    # Kimlik doğrulama servisi
│   │   │               │   ├── HashEncoder.kt    # Şifre hashleme
│   │   │               │   ├── JwtAuthFilter.kt  # JWT filtre
│   │   │               │   ├── JwtService.kt     # JWT işlemleri
│   │   │               │   └── SecurityConfig.kt # Güvenlik yapılandırması
│   │   │               └── SpringBootCrashCourseApplication.kt # Ana uygulama
│   │   └── resources/
│   │       └── application.properties # Uygulama yapılandırması
│   └── test/                        # Test dosyaları
├── build.gradle.kts                 # Gradle yapılandırması
├── settings.gradle.kts             # Gradle ayarları
├── gradlew                         # Gradle wrapper (Unix)
├── gradlew.bat                     # Gradle wrapper (Windows)
├── README.md                       # Proje dokümantasyonu
└── LICENSE                         # MIT lisansı
```

## 🚀 Özellikler

- JWT tabanlı kimlik doğrulama sistemi
- MongoDB veritabanı entegrasyonu
- Not oluşturma ve listeleme API'leri
- Güvenli şifre hashleme
- Refresh token desteği
- Spring Security entegrasyonu

## 🛠️ Teknolojiler

- Kotlin 1.9.25
- Spring Boot 3.4.5
- MongoDB
- JWT (JSON Web Tokens)
- Gradle (Kotlin DSL)
- Spring Security
- Spring Data MongoDB

## 🔐 API Endpoints

### Kimlik Doğrulama

- `POST /auth/register` - Yeni kullanıcı kaydı
  - Body: `{ "email": "user@example.com", "password": "Password123" }`

- `POST /auth/login` - Kullanıcı girişi
  - Body: `{ "email": "user@example.com", "password": "Password123" }`
  - Dönüş: `{ "accessToken": "...", "refreshToken": "..." }`

- `POST /auth/refresh` - Token yenileme
  - Body: `{ "refreshToken": "..." }`
  - Dönüş: `{ "accessToken": "...", "refreshToken": "..." }`

### Notlar

- `GET /notes` - Kullanıcının notlarını listele
  - Header: `Authorization: Bearer <access_token>`

- `POST /notes` - Yeni not oluştur
  - Header: `Authorization: Bearer <access_token>`
  - Body: `{ "title": "Not Başlığı", "content": "Not İçeriği", "color": 16777215 }`

## 🔒 Güvenlik

- Şifreler BCrypt ile hashlenir
- JWT tokenlar 15 dakika geçerlidir
- Refresh tokenlar 30 gün geçerlidir
- Tüm API endpointleri (auth hariç) kimlik doğrulama gerektirir
