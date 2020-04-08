# jniblur
在jni层调用bitmap 并实现高斯模糊

Bitmap在NDK中使用流程如下
##1 引入jnipraghics库，引用头文件bitmap.h ；
##2 调用AndroidBitmap_getInfo()以检索图片信息，例如指定的位图句柄的宽度和高度等；
##3 调用AndroidBitmap_lockPixels()以锁定像素缓冲区并检索指向他的指针，
   目的：确保了像素在应用调用AndroidBitmap_unlockPixels()之前不会移动，防止失帧；
##4 对像素缓冲区做相应的处理，（比如高斯模糊等图片算法处理）以达到我们各种图片处理目的；
##5 调用AndroidBitmap_unlockPixels()以解锁缓冲区。
