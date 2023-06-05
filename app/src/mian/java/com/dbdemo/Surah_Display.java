<?xml version="1.0" encoding="utf-8"?>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/drawer"
        tools:openDrawer="start"
        tools:context=".MainActivity">


<RelativeLayout
        android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:background="@drawable/img_10">

<androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"

        android:background="#610A70"
        app:title="Quran App"
        app:titleTextColor="@color/white" />

</RelativeLayout>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"

        tools:context=".MainActivity">




</androidx.constraintlayout.widget.ConstraintLayout>

<com.google.android.material.navigation.NavigationView
        android:id="@+id/nav_view"
        android:layout_gravity="start"
        android:layout_height="match_parent"
        android:layout_width="wrap_content"
        app:headerLayout="@layout/header"
        app:menu="@menu/navigation_menu"
        tools:ignore="MissingConstraints" />



</androidx.drawerlayout.widget.DrawerLayout>
