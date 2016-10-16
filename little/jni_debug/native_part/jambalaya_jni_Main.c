//
// Created by Timofey on 16.10.2016.
//
#include <stdlib.h>
#include "jambalaya_jni_Main.h"
JNIEXPORT jlong JNICALL Java_jambalaya_jni_Main_calcNative__II(JNIEnv * env, jclass class, jint a, jint b) {
    return b - a;

}

JNIEXPORT jint JNICALL Java_jambalaya_jni_Main_calcNative___3B(JNIEnv * env, jclass class, jbyteArray array) {
    jint res = 0;
    jsize length = (*env)->GetArrayLength(env, array);
    jint i;
    for (i = 0; i < length; i++) {
        res++;
    }
    return res;
}

