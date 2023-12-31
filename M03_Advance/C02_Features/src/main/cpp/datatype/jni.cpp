#include <jni.h>
#include <stdio.h>
#include <string>
#include <vector>
#include "net_bi4vmr_study_jni_datatype_JNIClass.h"

using namespace std;

// 传递基本数据类型参数
JNIEXPORT void JNICALL Java_net_bi4vmr_study_jni_datatype_JNIClass_passBasicTypes(
        JNIEnv *env, jobject instance, jboolean b, jint i, jdouble d) {
    // 将JNI数据类型转为C++原生数据类型
    bool b1 = b;
    long i1 = i;
    double d1 = d;

    // 使用转换后的变量（此处只是简单地在控制台输出它们）
    printf("PassBasicTypes. b1:[%s], i1:[%ld], d1:[%f]", b1 ? "true" : "false", i1, d1);
}

// 传递字符串参数
JNIEXPORT void JNICALL Java_net_bi4vmr_study_jni_datatype_JNIClass_passString(
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
JNIEXPORT void JNICALL Java_net_bi4vmr_study_jni_datatype_JNIClass_passStringArray(
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
JNIEXPORT jlong JNICALL Java_net_bi4vmr_study_jni_datatype_JNIClass_returnBasicTypes(
        JNIEnv *env, jobject instance) {
    // 生成随机数
    long num = random();
    // 将该数值返回给Java侧
    return num;
}

// 返回字符串
JNIEXPORT jstring JNICALL Java_net_bi4vmr_study_jni_datatype_JNIClass_returnString(
        JNIEnv *env, jobject instance) {
    // 测试字符串
    string text = "Return string value.";
    // 使用JNI的"NewStringUTF()"方法将C的字符指针转为Java字符串
    jstring data = env->NewStringUTF(text.c_str());
    // 将字符串返回给Java侧
    return data;
}
