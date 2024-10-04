#include <jni.h>
#include <stdio.h>
#include "net_bi4vmr_study_jni_base_JNIClass.h"

using namespace std;

JNIEXPORT void JNICALL Java_net_bi4vmr_study_jni_base_JNIClass_printInfo(JNIEnv *env, jobject instance) {
    printf("Hello World!");
}
