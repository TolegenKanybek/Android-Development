package com.example.vkrecyclerview

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import java.util.*

class News : Parcelable {
    var id = 0
    var accountPhotoUrl = 0
    var accountName: String? = null

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val news = o as News
        return id == news.id && accountPhotoUrl == news.accountPhotoUrl && postPhotoUrl == news.postPhotoUrl && likesUrl == news.likesUrl && likesCount == news.likesCount && liked == news.liked && userLike1 == news.userLike1 && userLike2 == news.userLike2 && userComUrl1 == news.userComUrl1 && userComReplyUrl1 == news.userComReplyUrl1 && userComLikeUrl1 == news.userComLikeUrl1 && userComLike1 == news.userComLike1 && commentsUrl == news.commentsUrl && postsUrl == news.postsUrl && viewersUrl == news.viewersUrl &&
                accountName == news.accountName &&
                date == news.date &&
                newsText == news.newsText &&
                likesDetail == news.likesDetail &&
                showCom == news.showCom &&
                userComAcc1 == news.userComAcc1 &&
                userComText1 == news.userComText1 &&
                userComDate1 == news.userComDate1 &&
                commentsCount == news.commentsCount &&
                postsCount == news.postsCount &&
                viewersCount == news.viewersCount
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun hashCode(): Int {
        return Objects.hash(id, accountPhotoUrl, accountName, date, newsText, postPhotoUrl, likesUrl, likesCount, liked, userLike1, userLike2, likesDetail, showCom, userComUrl1, userComAcc1, userComText1, userComDate1, userComReplyUrl1, userComLikeUrl1, userComLike1, commentsUrl, commentsCount, postsUrl, postsCount, viewersUrl, viewersCount)
    }

    var date: String? = null
    var newsText: String? = null
    var postPhotoUrl = 0
    var likesUrl = 0
    var likesCount = 0
    var liked = 0
    var userLike1 = 0
    var userLike2 = 0
    var likesDetail: String? = null
    var showCom: String? = null
    var userComUrl1 = 0
    var userComAcc1: String? = null
    var userComText1: String? = null
    var userComDate1: String? = null
    var userComReplyUrl1 = 0
    var userComLikeUrl1 = 0
    var userComLike1 = 0
    var commentsUrl = 0
    var commentsCount: String? = null
    var postsUrl = 0
    var postsCount: String? = null
    var viewersUrl = 0
    var viewersCount: String? = null

    constructor() {}
    constructor(id: Int, accountPhotoUrl: Int, accountName: String?, date: String?, newsText: String?, postPhotoUrl: Int, likesUrl: Int, likesCount: Int, liked: Int, userLike1: Int, userLike2: Int, likesDetail: String?, showCom: String?, userComUrl1: Int, userComAcc1: String?, userComText1: String?, userComDate1: String?, userComReplyUrl1: Int, userComLikeUrl1: Int, userComLike1: Int, commentsUrl: Int, commentsCount: String?, postsUrl: Int, postsCount: String?, viewersUrl: Int, viewersCount: String?) {
        this.id = id
        this.accountPhotoUrl = accountPhotoUrl
        this.accountName = accountName
        this.date = date
        this.newsText = newsText
        this.postPhotoUrl = postPhotoUrl
        this.likesUrl = likesUrl
        this.likesCount = likesCount
        this.liked = liked
        this.userLike1 = userLike1
        this.userLike2 = userLike2
        this.likesDetail = likesDetail
        this.showCom = showCom
        this.userComUrl1 = userComUrl1
        this.userComAcc1 = userComAcc1
        this.userComText1 = userComText1
        this.userComDate1 = userComDate1
        this.userComReplyUrl1 = userComReplyUrl1
        this.userComLikeUrl1 = userComLikeUrl1
        this.userComLike1 = userComLike1
        this.commentsUrl = commentsUrl
        this.commentsCount = commentsCount
        this.postsUrl = postsUrl
        this.postsCount = postsCount
        this.viewersUrl = viewersUrl
        this.viewersCount = viewersCount
    }

    override fun toString(): String {
        val sb = StringBuilder("News{")
        sb.append("accountPhotoUrl='").append(accountPhotoUrl).append('\'')
        sb.append(", accountName='").append(accountName).append('\'')
        sb.append(", date'").append(date).append('\'')
        sb.append(", newsText'").append(newsText).append('\'')
        sb.append(", postPhotoUrl'").append(postPhotoUrl).append('\'')
        sb.append(", likesCount'").append(likesCount).append('\'')
        sb.append(", commentsCount'").append(commentsCount).append('\'')
        sb.append(", postsCount'").append(postsCount).append('\'')
        sb.append(", viewersCount'").append(viewersCount)
        sb.append('}')
        return sb.toString()
    }

    override fun describeContents(): Int { //describeContents()-Описание виды специальных объектов, содержащихся
        // в правильном порядке представления этого экземпляра Parcelable.
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeInt(accountPhotoUrl)
        dest.writeString(accountName)
        dest.writeString(date)
        dest.writeString(newsText)
        dest.writeInt(postPhotoUrl)
        dest.writeInt(likesUrl)
        dest.writeInt(likesCount)
        dest.writeInt(liked)
        dest.writeInt(userLike1)
        dest.writeInt(userLike2)
        dest.writeString(likesDetail)
        dest.writeString(showCom) //private String showCom;
        dest.writeInt(userComUrl1) //private int userComUrl1;
        dest.writeString(userComAcc1) //private String userComAcc1;
        dest.writeString(userComText1) //private String userComText1;
        dest.writeString(userComDate1) //private String userComDate1;
        dest.writeInt(userComReplyUrl1) //private int userComReplyUrl1;
        dest.writeInt(userComLikeUrl1) //private int userComLikeUrl1;
        dest.writeInt(userComLike1) //private int userComLike1;
        dest.writeInt(commentsUrl)
        dest.writeString(commentsCount)
        dest.writeInt(postsUrl)
        dest.writeString(postsCount)
        dest.writeInt(viewersUrl)
        dest.writeString(viewersCount)
    }

    protected constructor(`in`: Parcel) {
        id = `in`.readInt()
        accountPhotoUrl = `in`.readInt()
        accountName = `in`.readString()
        date = `in`.readString() // конструктор, считывающий данные из Parcel
        newsText = `in`.readString()
        postPhotoUrl = `in`.readInt()
        likesUrl = `in`.readInt()
        likesCount = `in`.readInt()
        liked = `in`.readInt()
        userLike1 = `in`.readInt()
        userLike2 = `in`.readInt()
        likesDetail = `in`.readString()
        showCom = `in`.readString() //private String showCom;
        userComUrl1 = `in`.readInt() //private int userComUrl1;
        userComAcc1 = `in`.readString() //private String userComAcc1;
        userComText1 = `in`.readString() //private String userComText1;
        userComDate1 = `in`.readString() //private String userComDate1;
        userComReplyUrl1 = `in`.readInt() //private int userComReplyUrl1;
        userComLikeUrl1 = `in`.readInt() //private int userComLikeUrl1;
        userComLike1 = `in`.readInt() //private int userComLike1;
        commentsUrl = `in`.readInt()
        commentsCount = `in`.readString()
        postsUrl = `in`.readInt()
        postsCount = `in`.readString()
        viewersUrl = `in`.readInt()
        viewersCount = `in`.readString()
    }

    companion object {

        val cREATOR: Parcelable.Creator<News> = object : Parcelable.Creator<News?> {
            override fun createFromParcel(source: Parcel): News? {
                return News(source)
            }

            override fun newArray(size: Int): Array<News?> {
                return arrayOfNulls(0) //Create a new array of the Parcelable class.
            }
        }
    }
}