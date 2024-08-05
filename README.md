<h1 align="center">Klivvr Android Task</h1>


# Tech Stacks

- MVVM Architecture: The Arch promotes reusability of code, greatly simplifying the process of creating simple user interfaces
- Jetpack Compose: Using Modern Tech of Jetpack Compose.

# File Loading 

After Reading  the description all my concern was how to load and handle such a big file and handle that big amount of data so i decided to take it step by step : 

- Reading Json File :

  ```kotlin
    val jsonString = context.resources.openRawResource(R.raw.cities).bufferedReader().readText()
    val json = Json { ignoreUnknownKeys = true }
    return json.decodeFromString<List<City>>(jsonString).sortedBy { it.name }
  ```

- Now we have total json Entries. That easy right, but in the description i read we should handle searching complexity to be better than O(n) so we need to use data structure and what come immediately to my mind is using hashmap as we know search complexity is O(1): 
  ``` kotlin
    entries = cityFileService.loadCities()

    for (entry in entries) {
      for (i in 1..entry.name.length) {
        val prefix = entry.name.substring(0, i).lowercase(Locale.ROOT)
        nameMap.computeIfAbsent(prefix)
        { mutableListOf() }.add(entry)
      }
  ```

   As You can notice now I used hashmap <String, MutableList> for all possible prefixes in all Strings (I know you are thinking about the size of the hashmap but it's not big as you think), you can find the sizes below : 
   ```
   entries size = 209557
   hashmap size = 795471
   ``` 
   I think the size is acceptable, cost of getting good search complexity like O(1) (Its a good deal)


# UI 
I built Single Screen containg searchbar for filtering and Lazy Column for listing all Cities. I followed State , Events Conecepts in my viewmodel :

```kotlin
sealed class MainScreenEvents {

  data class OnQueryChange(val query: String) : MainScreenEvents()

}
data class MainScreenState(
  val query: String ="", // For holding query in the searchbar 
  val currentCities : List<City> = emptyList(),// For holding current cities to be showed on Screen 
  val isLoaded :Boolean = false //Indicator for proccess of loading and mapping the file
  )
```



  
