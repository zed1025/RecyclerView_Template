# RecyclerView_Template
RecyclerView basics, including Horizontal and Vertical RecyclerViews. Click listener for RecyclerView items.


## Android SDK Info
* minSdkVersion 14
* targetSdkVersion 26
* compileSdkVersion 26

## Dependencies
Dependency for RecyclerView

compile 'com.android.support:recyclerview-v7:26.1.0'

## Documentation
[AndroidHive RecyclerView](https://www.androidhive.info/2016/01/android-working-with-recycler-view/)

1. In Android Studio, go to File ⇒ New Project and fill all the details required to create a new project. When it prompts to select a default activity, select Blank Activity and proceed.
2. Open build.gradle and add recycler view dependency. com.android.support:recyclerview-v7:26.1.0 and rebuild the project.
```gradle
apply plugin: 'com.android.application'
 
android {
    compileSdkVersion 26
    buildToolsVersion '26.0.2'
    // ..
}
 
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //..
 
    // RecyclerView
    implementation 'com.android.support:recyclerview-v7:26.1.0'
}
```
3. With the latest version of build tools, Android Studio is creating two layout files for each activity. For main activity, it created activity_main.xml (contains CoordinatorLayout and AppBarLayout) and content_main.xml (for the actual content). Open content_main.xml and the recycler view widget.
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:showIn="@layout/activity_main"
    tools:context=".MainActivity">
 
    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scrollbars="vertical" />
 
</RelativeLayout>
```
4. Open colors.xml located under res ⇒ values and add below colors.
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="year">#999999</color>
    <color name="title">#222222</color>
</resources>
```
5. Open dimens.xml located under res ⇒ values and add the dimensions.
```xml
<resources>
    <!-- Default screen margins, per the Android Design guidelines. -->
    <dimen name="activity_horizontal_margin">16dp</dimen>
    <dimen name="activity_vertical_margin">16dp</dimen>
    <dimen name="fab_margin">16dp</dimen>
    <dimen name="row_padding_vertical">10dp</dimen>
</resources>
```
6. Create a class named Movie.java and declare title, genre and year. Also add the getter/setter methods to each variable.
```java
package inc.thebest.recyclerview_template;
 
public class Movie {
    private String title, genre, year;
 
    public Movie() {
    }
 
    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String name) {
        this.title = name;
    }
 
    public String getYear() {
        return year;
    }
 
    public void setYear(String year) {
        this.year = year;
    }
 
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
```
7. Create an layout xml named movie_list_row.xml with the below code. This layout file renders a single row in recycler view by displaying movie name, genre and year of release.
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="?android:attr/selectableItemBackground"
    android:clickable="true"
    android:focusable="true"
    android:orientation="vertical"
    android:paddingBottom="@dimen/row_padding_vertical"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/row_padding_vertical">
 
    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:textColor="@color/title"
        android:textSize="16dp"
        android:textStyle="bold" />
 
    <TextView
        android:id="@+id/genre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/title" />
 
    <TextView
        android:id="@+id/year"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:textColor="@color/year" />
 
</RelativeLayout>
```
8. Now create a class named MoviesAdapter.java and add the below code. Here onCreateViewHolder() method inflates movie_list_row.xml. In onBindViewHolder() method the appropriate movie data (title, genre and year) set to each row.
```java
package inc.thebest.recyclerview_template;
 
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
import java.util.List;
 
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
 
    private List<Movie> moviesList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
 
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
 
 
    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }
 
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
```
9. Now open MainActivity.java and do the below changes. Here prepareMovieData() method adds sample data to list view.
```java
package inc.thebest.recyclerview_template;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
 
import java.util.ArrayList;
import java.util.List;
 
public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
 
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
 
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
 
        prepareMovieData();
    }
 
    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
 
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
 
        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);
 
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
 
        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);
 
        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);
 
        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);
 
        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);
 
        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);
 
        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
 
        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);
 
        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);
 
        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);
 
        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);
 
        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);
 
        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
 
        mAdapter.notifyDataSetChanged();
    }
}
```
**Now if you run the app, you can see the movies displayed in a list manner.**

## Adding RecyclerView Divider / Separator
You can add the divider line between rows by using DividerItemDecoration provided by support library. Add item decoration on RecyclerView as shown below.

```java
recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
 
// set the adapter
recyclerView.setAdapter(mAdapter);
```

**Now if you run the app, you should see a divider line separating each row.**

## Custom Divider Line with Margins
The default divide occupies the full width of item row. In some scenarios you might wanna add margin to divider line. For that you need to create a custom divider class by providing necessary margins and divider color.

Create a class named MyDividerItemDecoration.java and extend the class from ItemDecoration and use addItemDecoration() method to display the divider.

```java
package inc.thebest.recyclerview_template;
 
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
 
/**
 * Created by Ravi on 30/10/15.
 * updated by Ravi on 14/11/17
 */
public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {
 
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };
 
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
 
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
 
    private Drawable mDivider;
    private int mOrientation;
    private Context context;
    private int margin;
 
    public MyDividerItemDecoration(Context context, int orientation, int margin) {
        this.context = context;
        this.margin = margin;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }
 
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }
 
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }
 
    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
 
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left + dpToPx(margin), top, right - dpToPx(margin), bottom);
            mDivider.draw(c);
        }
    }
 
    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
 
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top + dpToPx(margin), right, bottom - dpToPx(margin));
            mDivider.draw(c);
        }
    }
 
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
 
    private int dpToPx(int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
```

Open MainActivity.java and set the custom decoration using addItemDecoration() method before setting the adapter. Below margin of 16dp is added on left and right side of divider line.

```java
recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
 
// set the adapter
recyclerView.setAdapter(mAdapter);
```

**Now if you run the app, you should see a divider line separating each row.**

## Displaying Horizontal Scrolling RecyclerView
If you want to display the RecyclerView in Horizontal manner, you can do that just by changing a single line of code. All you have to do is provide direction to layout manager i.e LinearLayoutManager.HORIZONTAL as shown below. Also don’t forget to keep your row layout width to WRAP_CONTENT.

```java
// horizontal RecyclerView
// keep movie_list_row.xml width to `wrap_content`
RecyclerView.LayoutManager mLayoutManager = 
new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
```

## Adding RecyclerView Item Click Listener
Use Library
[RecycleClick](https://github.com/ChathuraHettiarachchi/RecycleClick)

**Run the app and verify the item click. You should able to see a toast message upon clicking on a row. You can also notice that a background ripple effect when testing on lollipop device.**
