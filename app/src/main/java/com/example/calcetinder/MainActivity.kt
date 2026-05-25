package com.example.calcetinder

/**
 * Proyecto: Calcetinder
 * Asignatura: Diseño de Interfaces
 * Alumno: David Merchán Rivero
 * Curso: 3º DAM - Arriaga Egibide
 */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.calcetinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController
        setupActionBarWithNavController(navController, AppBarConfiguration(navController.graph))
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()
}