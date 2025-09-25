# TeachLink App 📚✨

TeachLink is an **Android CRUD application** built with **Java** and integrated with **Firebase** to manage teacher records.  
The app provides a secure and user-friendly platform where users can register, log in, recover passwords, and manage teacher data in real-time.  

---

## 🚀 Features
- ✅ Add new teacher records  
- ✅ Display teacher list dynamically from Firebase  
- ✅ Edit/update existing teacher records  
- ✅ Delete teacher records  
- ✅ Real-time data management using Firebase Realtime Database  
- ✅ Login/Register with Firebase Authentication  
- ✅ Forgot Password (Password Reset via Email)  
- ✅ Image Upload using Firebase Storage  
- ✅ Progress Bar for smooth data operations  

---

## 🛠️ Tech Stack
- **Language:** Java (Android Development)  
- **Database:** Firebase Realtime Database  
- **Authentication:** Firebase Authentication  
- **Storage:** Firebase Storage  
- **UI Framework:** XML (Android Layouts)  

**Libraries Used:**  
- Firebase UI  
- Glide (for image loading)  
- DialogPlus (for edit dialogs)  
- CircleImageView (for profile images)  
- Firebase Auth & Storage  

---

## 📂 Project Structure
- `HomeActivity.java` → Displays teacher list  
- `AddData.java` → Add new teacher records  
- `MyAdapter.java` → Custom RecyclerView adapter  
- `Model.java` → Teacher data structure  
- `LoginActivity.java` → User login  
- `RegisterActivity.java` → User registration  
- `ForgotPasswordActivity.java` → Password reset  
- `ProfileActivity.java` → User profile  

**Layouts:**  
- `activity_adddata.xml` → Add teacher  
- `activity_home.xml` → Home screen  
- `activity_login.xml` → Login screen  
- `activity_register.xml` → Registration screen  
- `activity_forgotpassword.xml` → Password reset  
- `singlerow.xml` → RecyclerView item layout  
- `dialogcontent.xml` → Edit dialog layout  

---

## 🔧 Installation & Setup
1. **Clone the repository**
   git clone https://github.com/userali4239/Teach-Link

2. **Open in Android Studio**

3. **Add Firebase dependencies** in build.gradle:

implementation 'com.google.firebase:firebase-database:20.2.1'
implementation 'com.firebaseui:firebase-ui-database:8.0.2'
implementation 'com.github.bumptech.glide:glide:4.12.0'
implementation 'com.orhanobut:dialogplus:1.11'
implementation 'com.google.firebase:firebase-auth:21.0.5'
implementation 'com.google.firebase:firebase-storage:20.0.0'

4. **Configure Firebase**
Create a Firebase project
Enable Realtime Database, Authentication & Storage
Download google-services.json and place it inside app/ folder

6. **Run the App**
Connect an Android device or use an emulator
Click ▶ Run in Android Studio

**🔮 Future Improvements**
Add advanced user roles & authentication
Enhanced Material Design UI
Implement search and filtering features
Expand dashboard for analytics

**📩 Contact**
👤 Ali Raza Warriach
📧 userali4239@gmail.com
🌐 LinkedIn : https://www.linkedin.com/in/userali4239
