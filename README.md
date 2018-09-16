# ShowPhotoFromGallery
This is a sample to show photos that are selected and shared from gallery in Android. Photo can be selected as singe or multiple from gallery to
shared an application in phone. To appear the application in list that is showed when click the share button, AndroidManifest.xml is
updated with these intent-filter. One for single photo and one for multiple photos orderly.

![alt text](ss/1.PNG)

To handle the content delivered, intent is used in MainActivity.java.There are some differences between single and multiple. If one photo
being shared, it casts Uri. Differently, content casts Uri list while multiple photo being shared.

Intent.ACTION_SEND is used to handle single photo and Intent.ACTION_SEND_MULTIPLE is used to handle multiple photos.

![alt text](ss/2.PNG)

Screen shots:

![alt text](ss/3.PNG)
