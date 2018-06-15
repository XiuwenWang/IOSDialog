- ### 	[![](https://jitpack.io/v/XiuwenWang/IOSDialog.svg)](https://jitpack.io/#XiuwenWang/IOSDialog)
 Step 1. Add the JitPack repository to your build file
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 Step 2. Add the dependency
```
dependencies {
	      implementation 'com.github.XiuwenWang:IOSDialog:1.1'
	}
```
# IOSDialog（仿IOS样式）
> - ### IOSAlert（屏幕中间显示的对话框）
 使用方法（可修改文字样式，可自定义消息内容（传View））
```
     new IOSAlert.Builder(this)
             .setTitle("标题")
             .setMessage("消息内容")  
             .setPositiveButton("确定", new IOSAlert.OnClickListener() {
                 @Override
                 public void onClick(IOSAlert dialog) {
                     Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                 }
             })
             .setNegativeButton("取消")
             .show();
```
***
> - ### IOSSheet（屏幕底部弹起的对话框）
使用方法（可修改文字样式，可自定义内容（传View））
```
     new IOSSheet.Builder(this)
             .setTitle("标题")
             .addSheetItem("0")
             .addSheetItem(new String[]{"1", "2", "3"})
             .addSheetItem("5", Color.RED,15)
             .setOnItemClickListener(new IOSSheet.OnItemClickListener() {
                 @Override
                 public void onClick(int position, IOSSheet dialog) {
                     //Item 点击回调
                 }
             })
             .setNegativeButton("取消")
             .show();
```
