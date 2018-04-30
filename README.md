# mercari-android-test
For Technical interview 

## Description

![screenshot](https://preview.ibb.co/fst4d5/Screen_Shot_2017_05_05_at_2_56_26_PM.png)

- Build an app that loads data from `all.json` which is stored in `assets`, and make the app look like the above screenshot.
- Write in a such way that data retrieval implementation can be easily replaced. For example, it is currenly loaded from `all.json` file but in the near future we might want to fetch the data from network.
- In the item cell view, it needs to display item image from `photo`, title from `name`, and price from `price`.
- JSON representation of Java classes are pre-defined. See `com.mercari.mercaritest.data.model.Item` and `com.mercari.mercaritest.data.model.Response`.
- For price background, use `item_price_background.xml` with a text style of `black_14_white`.
- For item name, use `regular_14_black_70op` text style.
- You are encouraged to build dependency graphs using [Dagger](https://google.github.io/dagger/)
- You are encouraged to use [RxJava](https://github.com/ReactiveX/RxJava)
- display `sold.png` as shown when `Item.status` equals to `sold_out`.
- Even though this app is relatively simple, please write code in "production ready" level; that is, write in a way that you would normally do on production app.
- Basic unit tests for bonus points
- Please use a known architecture with justification for your choice included, explained in README

When you have questions, please don't hesitate to ask!

### Estimated time commitment: 2 hours

## Instructions for submitting the exercise
1. Create a new git repo and use the provided project as a base to complete the assignment, committing with frequency and with the type of commit messages you would write on a typical project.
2. Submit with README that gives and overview of the project with technical detail
3. Zip up the repo and send back an email with attachment when you’ve completed the exercise and we will review it as soon as possible.
4. We’ll build it your app directly from the repo you provide



Solution :
Install apk on an android device and launch it.
1. I have used recycler view with grid layput to show all items.
2. When app launched, you will see all itsm with their price and name and image too. However, I am getting below error message when I try to download image from url (given in all.json) 
Error - <html>
<head><title>301 Moved Permanently</title></head>
<body bgcolor="white">
<center><h1>301 Moved Permanently</h1></center>
<hr><center>nginx</center>
</body>
</html>



3. I wanted to use RxJava and Retrofit to perform the task of downloading images (and also can be used for say getting json data from a url). But I am new to these libraries as I have recently started using them and when I tried to apply them here, I observed it was taking longer time. So in order to have a running solution, I used standard AsyncTask mechanism for network operation.

4. While displaying items, what I do is in recycler view show static data like price, name, etc. and then parallely download images and show them. This way, even if image download takes longer, the data will be shown and as soon as image is downloaded it gets shown in imageView. (but because of above error in point 2 I couldn't see them. I could see oter test images there when I debugged).

5. In a production case, I would actually also use MVP / MVVM pattern, so that I can keep view separate from business logic. In this submission though, I haven't separated business logic yet because of time constraints.
