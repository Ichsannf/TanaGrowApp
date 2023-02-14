package org.d3ifcool.tanagrow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3ifcool.tanagrow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNav.selectedItemId = R.id.plantsFragment

        setBtnNav()
    }

    private fun setBtnNav() {
        binding.btnNav.selectedItemId = R.id.plantsFragment


        binding.btnNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.plants_menu->{
                    openFragment(PlantsFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.article_menu-> {
                    openFragment(ArticleFragment())
                    return@setOnItemSelectedListener true
                }
                else -> {return@setOnItemSelectedListener false
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrame, fragment)
            .addToBackStack(null)
            .commit()
    }

}