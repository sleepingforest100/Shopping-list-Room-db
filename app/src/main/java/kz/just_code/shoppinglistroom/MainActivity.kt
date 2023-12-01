package kz.just_code.shoppinglistroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import dagger.hilt.android.AndroidEntryPoint
import kz.just_code.shoppinglistroom.databinding.ActivityMainBinding
import kz.just_code.shoppinglistroom.databinding.DialogAddShoppingItemBinding
import kz.just_code.shoppinglistroom.general.hide
import kz.just_code.shoppinglistroom.general.show
import kz.just_code.shoppinglistroom.presentation.MainViewModel
import kz.just_code.shoppinglistroom.presentation.ShoppingListAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ShoppingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupAddShoppingItemButtons()
    }

    private fun setupRecyclerView() {
        binding.progressBar.show()
        binding.emptyShoppingListContainer.hide()
        binding.shoppingListContainer.hide()
        adapter = ShoppingListAdapter(
            onBuyItemClick = {
                viewModel.setIsBought(it)
            },
            onDeleteClick = {
                viewModel.deleteShoppingItem(it)
            }
        )
        binding.shoppingList.adapter = adapter

        viewModel.shoppingList.observe(this@MainActivity) { list ->
            binding.progressBar.hide()
            binding.counter.text = "${list.count { it.isBought }}/${list.size}"
            adapter.submitList(list)

            when(list.size){
                0->{
                    binding.emptyShoppingListContainer.show()
                    binding.shoppingListContainer.hide()
                }
                else->{
                    binding.emptyShoppingListContainer.hide()
                    binding.shoppingListContainer.show()
                }
            }
        }
    }
    private fun showAddItemDialog(){
        val alertBinding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this).apply{
            setView(alertBinding.root)
        }
        val dialog = builder.create()

        alertBinding.cancel.setOnClickListener{
            dialog.dismiss()
        }
        alertBinding.save.setOnClickListener{
            val editText = alertBinding.addEditText
            val name = editText.text.toString()

            if (name.isBlank()){
                editText.error = "Item name can not be empty. Please add item"
               return@setOnClickListener
            }

            viewModel.addShoppingItem(name)
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun setupAddShoppingItemButtons(){
        binding.emptyShoppingListButton.setOnClickListener{
            showAddItemDialog()
        }
        binding.shoppingListButton.setOnClickListener{
            showAddItemDialog()
        }
    }

}