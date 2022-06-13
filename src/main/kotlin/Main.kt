import api.RiotApiClient
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    // get an instance of the Riot Games Api
    val riotService = RiotApiClient.getService()

    // download all the game versions available. This will return a List<String>
    val gameVersions = riotService.listVersions()

    println("Game Versions available:")
    println(gameVersions.toString())

    // get the first position (or the newest version)
    val lastestVersion = gameVersions.first()

    // download all the champions from this version
    val championList = riotService.getAllChampions(lastestVersion)

    println("Listing all the champions from version $lastestVersion:")
    championList.data.forEach { (_, champion) ->
        println(champion.toString())
    }
}