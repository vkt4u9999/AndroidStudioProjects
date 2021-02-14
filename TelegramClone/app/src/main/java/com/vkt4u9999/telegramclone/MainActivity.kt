package com.vkt4u9999.telegramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.vkt4u9999.telegramclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        ProfileDrawerItem().withName("Igor Pleshkov")
                                .withEmail("+375333355500")
                ).build()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                //ГАМБУРГЕР
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        PrimaryDrawerItem().withIdentifier(100)
                                .withIconTintingEnabled(true)
                                .withName("Создать группу")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_groups),
                        PrimaryDrawerItem().withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Создать секретный чат")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_secret_chat),
                        PrimaryDrawerItem().withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Создать канал")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_channel),
                        PrimaryDrawerItem().withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Контакты")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_contacts),
                        PrimaryDrawerItem().withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Звонки")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_phone),
                        PrimaryDrawerItem().withIdentifier(105)
                                .withIconTintingEnabled(true)
                                .withName("Избранное")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_favorites),
                        PrimaryDrawerItem().withIdentifier(106)
                                .withIconTintingEnabled(true)
                                .withName("Настройки")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_settings),
                        DividerDrawerItem(),
                        PrimaryDrawerItem().withIdentifier(107)
                                .withIconTintingEnabled(true)
                                .withName("Пригласить друзей")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_invate)
                                .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                                    override fun onItemClick(
                                            view: View?,
                                            position: Int,
                                            drawerItem: IDrawerItem<*>
                                    ): Boolean {
                                        return false
                                    }
                                })
                ).build()
    }


}