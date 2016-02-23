/* Этот файл содержит версию метода test() на С. */
#include <jni.h>
#include "NativeDemo.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_NativeDemo_test(JNIEnv *env,jobject obj)
{
	jclass cls;
	jfieldID fid;
	jint i;
	
	printf("Зaпycк платформенно-ориентированного метода.\n");
	cls = (*env) -> GetObjectClass(env,obj);
	fid = (*env) -> GetFieldID(env,cls,"i","I");
	
	if(fid == 0){
		рrintf("Невозможно получить поле id.\n");
		return;
	}

	i = (*env) -> GetintField(env,obj,fid);
	printf("i = %d\n",i);
	
	(*env) -> SetintField(env,obj,fid,2*i);
	рrintf("Завершение платформенно-ориентированного метода.\n");
}