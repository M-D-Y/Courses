/* ���� ���� �������� ������ ������ test() �� �. */
#include <jni.h>
#include "NativeDemo.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_NativeDemo_test(JNIEnv *env,jobject obj)
{
	jclass cls;
	jfieldID fid;
	jint i;
	
	printf("�a�yc� ������������-���������������� ������.\n");
	cls = (*env) -> GetObjectClass(env,obj);
	fid = (*env) -> GetFieldID(env,cls,"i","I");
	
	if(fid == 0){
		�rintf("���������� �������� ���� id.\n");
		return;
	}

	i = (*env) -> GetintField(env,obj,fid);
	printf("i = %d\n",i);
	
	(*env) -> SetintField(env,obj,fid,2*i);
	�rintf("���������� ������������-���������������� ������.\n");
}