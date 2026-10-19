TAFSIR AUTO PLAY MODZ — Android starter project
================================================

এই প্রজেক্টে আছে:
- Login screen (username/password)
- Demo admin screen-এ user/subscription record দেখানোর কাঠামো
- Subscription expiry যাচাইয়ের নমুনা
- পরিষ্কারভাবে চিহ্নিত DEMO authentication

গুরুত্বপূর্ণ:
এই starter project-এ authentication স্থানীয় demo data দিয়ে করা হয়। এটি production security নয়।
শুধু APK বানিয়ে password-কে নিরাপদ রাখা যায় না। বাস্তব ব্যবহার করার আগে server/backend,
HTTPS API, password hashing, admin authentication, rate limiting এবং secure session যোগ করুন।
এখানে ডিফল্ট demo login: admin / ChangeMe123!
প্রথম ব্যবহারের পর অবশ্যই পরিবর্তন করুন। এই demo login বাস্তব সার্ভিসে ব্যবহার করবেন না।

এই ফাইলগুলো Android Studio/Gradle project-এর starter scaffold। এই পরিবেশে Android SDK দিয়ে
APK compile/test করা হয়নি; তাই এখানে APK binary দেওয়া হয়নি। মোবাইল-only workflow-তে
বিশ্বস্ত Android build environment/সাহায্য লাগতে পারে।

Aim AI Engine APK ইন্টিগ্রেশন এই starter-এ করা হয়নি। আগে APK-এর package, exported components,
permissions, signatures ও compatibility যাচাই করতে হবে। অন্য অ্যাপের security/anti-cheat bypass
বা অননুমোদিত automation এতে অন্তর্ভুক্ত নয়।
