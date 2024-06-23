#include <jni.h>
#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

// 传递基本数据类型参数
JNIEXPORT void JNICALL passBasicTypes(
        JNIEnv *env, jobject instance, jboolean b, jint i, jdouble d) {
    // 将JNI数据类型转为C++原生数据类型
    bool b1 = b;
    long i1 = i;
    double d1 = d;

    // 使用转换后的变量（此处只是简单地在控制台输出它们）
    printf("PassBasicTypes. b1:[%b], i1:[%ld], d1:[%f]", b1, i1, d1);
}

// 传递字符串参数
JNIEXPORT void JNICALL passString(
        JNIEnv *env, jobject instance, jstring str) {
    // 将数组元素转为字符指针
    const char *pString = env->GetStringUTFChars(str, nullptr);
    // 将字符指针转为C++字符串
    string cString = string(pString);
    // 释放资源
    env->ReleaseStringUTFChars(str, pString);

    // 使用转换后的变量（此处只是简单地在控制台输出它们）
    printf("PassString. Content:[%s]", cString.c_str());
}

// 传递字符串数组参数
JNIEXPORT void JNICALL passStringArray(
        JNIEnv *env, jobject instance, jobjectArray stringArray) {
    // 获取数组总长度
    int count = env->GetArrayLength(stringArray);
    // 创建C++列表存储结果
    vector<string> list = vector<string>(count);
    // 遍历Java数组，获取字符串。
    for (int i = 0; i < count; i++) {
        // 获取数组元素，并转换为C++的String。
        auto jString = (jstring) (env->GetObjectArrayElement(stringArray, i));
        // 将数组元素转为字符指针
        const char *pString = env->GetStringUTFChars(jString, nullptr);
        // 将字符指针转为C++字符串
        string cString = string(pString);
        // 释放资源
        env->ReleaseStringUTFChars(jString, pString);
        // 将字符串存储至集合
        list[i] = cString;
    }

    // 使用转换后的变量（此处只是简单地在控制台输出它们）
    for (int j = 0; j < list.size(); j++) {
        printf("PassStringArray. Index:[%d], Content:[%s]", j, list[j].c_str());
    }
}

// 返回基本数据类型
JNIEXPORT jlong JNICALL returnBasicTypes(
        JNIEnv *env, jobject instance) {
    // 生成随机数
    long num = random();
    // 将该数值返回给Java侧
    return num;
}

// 返回字符串
JNIEXPORT jstring JNICALL returnString(
        JNIEnv *env, jobject instance) {
    // 测试字符串
    string text = "Return string value.";
    // 使用JNI的"NewStringUTF()"方法将C的字符指针转为Java字符串
    jstring data = env->NewStringUTF(text.c_str());
    // 将字符串返回给Java侧
    return data;
}

/*
 * 结构体数组，用于声明当前Native类包含的所有JNI方法。
 *
 * 每个结构体有三个参数，它们的含义分别如下文列表所示：
 * 第一参数：Java本地方法的名称。
 * 第二参数：Java本地方法的方法签名。
 * 第三参数：C语言函数的指针。
 */
static const JNINativeMethod jniNativeMethod[] = {
        {(char *) "passBasicTypes",   (char *) "(ZID)V",                 (void *) (passBasicTypes)},
        {(char *) "passString",       (char *) "(Ljava/lang/String;)V",  (void *) (passString)},
        {(char *) "passStringArray",  (char *) "([Ljava/lang/String;)V", (void *) (passStringArray)},
        {(char *) "returnBasicTypes", (char *) "()J",                    (void *) (returnBasicTypes)},
        {(char *) "returnString",     (char *) "()Ljava/lang/String;",   (void *) (returnString)},
};

/**
 * Name        : JNI_OnLoad
 * <p>
 * Description : 回调方法，当Java层执行至"System.loadLibrary()"方法时，该方法被触发。
 *
 * @param jvm      JVM环境变量。
 * @param reserved 保留参数，暂不使用。
 * @return 加载结果，返回值为JNI版本时表示成功，其他值则表示失败，具体含义详见"jni.h"中的宏定义。
 */
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
    // 通过JavaVM，获取JNIEnv实例。
    JNIEnv *jniEnv = nullptr;
    // 该方法的第二个参数是JNI标准版本号，常用的值为"1.6"。
    jint result = jvm->GetEnv(reinterpret_cast<void **>(&jniEnv), JNI_VERSION_1_6);
    // 判断JNIEnv初始化结果
    if (result == JNI_OK) {
        // 绑定目标Native类，参数为类的完全限定名称，点(".")需要替换为斜杠("/")。
        jclass jniClass = jniEnv->FindClass("net/bi4vmr/study/jni/dynamic/JNIClass");
        // 获取JNI方法的数量
        long arraySize = sizeof(jniNativeMethod) / sizeof(JNINativeMethod);
        /*
         * 动态注册Native方法，各参数的含义分别为：
         * 第一参数为Native类的Class。
         * 第二参数为JNI方法结构体数组。
         * 第三参数为数组的长度。
         */
        jniEnv->RegisterNatives(jniClass, jniNativeMethod, arraySize);
        return JNI_VERSION_1_6;
    } else {
        return JNI_ERR;
    }
}

/**
 * Name        : JNI_OnUnload
 * <p>
 * Description : 回调方法，当JVM回收本C++类对应的Java类时，该方法被触发。
 *
 * @param jvm      JVM环境变量。
 * @param reserved 保留参数，暂不使用。
 */
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *jvm, void *reserved) {
    JNIEnv *jniEnv = nullptr;
    jint result = jvm->GetEnv(reinterpret_cast<void **>(&jniEnv), JNI_VERSION_1_6);
    if (result == JNI_OK) {
        jclass jniClass = jniEnv->FindClass("net/bi4vmr/study/jni/dynamic/JNIClass");
        // 注销Native方法
        jniEnv->UnregisterNatives(jniClass);
    }
}
