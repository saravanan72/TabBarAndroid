package com.jean.martin.android.app.tabbarandroid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jean.martin.android.app.tabbarandroid.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /*
        Assigning view variables to thier respective view in xml
        by findViewByID method
         */

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */

        final TabLayout.Tab home = tabLayout.newTab();
        final TabLayout.Tab inbox = tabLayout.newTab();
        final TabLayout.Tab star = tabLayout.newTab();

        //Setting Icons to our respective tabs

        home.setIcon(R.drawable.ic_home_white);
        inbox.setIcon(R.drawable.ic_inbox_grey);
        star.setIcon(R.drawable.ic_star_grey);

        /*
        Adding the tab view to our tablayout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablayout and like wise for other tabs as well
         */
        tabLayout.addTab(home, 0);
        tabLayout.addTab(inbox, 1);
        tabLayout.addTab(star, 2);

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indiactor below the tabs
         */

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));
        tabLayout.setSelectedTabIndicatorHeight(7);

        /*
        Adding a onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.

        2nd We add the onPageChangeListener to change the icon when the page changes in the view Pager
         */

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        /*
                        setting Home as White and rest grey
                        and like wise for all other positions
                         */
                        home.setIcon(R.drawable.ic_home_white);
                        inbox.setIcon(R.drawable.ic_inbox_grey);
                        star.setIcon(R.drawable.ic_star_grey);
                        break;
                    case 1:
                        home.setIcon(R.drawable.ic_home_grey);
                        inbox.setIcon(R.drawable.ic_inbox_white);
                        star.setIcon(R.drawable.ic_star_grey);
                        break;
                    case 2:
                        home.setIcon(R.drawable.ic_home_grey);
                        inbox.setIcon(R.drawable.ic_inbox_grey);
                        star.setIcon(R.drawable.ic_star_white);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
