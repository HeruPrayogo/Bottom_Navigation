package com.example.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val homefragment= HomeFragment()
        val searchfragment= SearchFragment()
        val explorefragment= ExploreFragment()

        setCurrentFragment(homefragment)

         binding.bottomNavigationView.setOnNavigationItemReselectedListener {
             when (it.itemId) {
                 R.id.Home -> setCurrentFragment(homefragment)
                 R.id.pencarian -> setCurrentFragment(searchfragment)
                 R.id.explore -> setCurrentFragment(explorefragment)
             }
             true
         }
        }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }
}