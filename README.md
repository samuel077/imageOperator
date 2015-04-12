# imageOperator
This is the simple but original, keep updated image operator created to help everybody do some image operation on the internet or the local. 

We try to get to know the original operation process of image, in the path of knowing deeper, we'll try to make our demo program 
work more efficiency, with more fluency. 

If there's any good things/usage that you can think of, please remind us, and we'll help to modify it and make it better.

# Usage
In the very first version, we try to make our api readible. 
Here's the usage in our api :

ImageOperator imageOperator = ImageOperator.getInstance(context);
imageOperator.grabImage(url).onImageView(imageView).withErrorMsg(errorMsg).start();

url : the image url on the internet.
imageView : the imageView in layout.
errorMsg : the error message you want to show when fetch image went wrong.

More useful functionality will be provided in the future. Such as cacheable, load local file. 
To be updated.
