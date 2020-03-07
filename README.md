# Music App Project

The goal of this project was to gain experience working with the android model view viewmodel architecture by creating a music app for viewing chart tracks, searching for tracks and artsits and creating/editing playlists. The app uses the Deezer music api to retieve track information and stores playlist data in a data base.

Api calls were made using the Retrofit 2.0 and Moshi libraries.

A room database was used to store playlist information.

## Features

**Top Tracks**
Displays the current top 10 tracks in a grid recycler view when the app is opened.

<img src="/pics/home.png" alt="Top Tracks" width="200px"/>

**Search for Tracks**
Users can search for tracks and view all results in a grid recycler view.

<img src="/pics/searchTracks.png" alt="Search Tracks" width="200px"/>

**View Tracks**
Users can click on any track in the app to view track information and add the track to a playlist.

<img src="/pics/viewTrack1.png" alt="Track View" width="200px"/>
<img src="/pics/viewTrack2.png" alt="Track View 2" width="200px"/>

**Search for Artists**
Users can search for artsits and view all results in a grid recycler view.

<img src="/pics/searchArtist.png" alt="Search Artists" width="200px"/>

**View Artists**
Users can click on an artist to view the artists name, image and a grid recyler view of their top tracks.

<img src="/pics/viewArtist.png" alt="View artist" width="200px"/>

**View Playlsits**
Users can swipe between the top tracks view and a list of their playlists.

<img src="/pics/viewPlaylists.png" alt="View Playlists" width="200px"/>

**Create Playlist**
Users can create a playlist by clicking to plus button to bring up a dialog box where the user can input playlist information.

<img src="/pics/createPlaylist.png" alt="Create PLaylists" width="200px"/>

**View a Playlist**
Playlists can be clicked to view playlist information and the tracks they contain.

<img src="/pics/viewPlaylist.png" alt="View playlist" width="200px"/>

**Delete a Track from a Playlist**
Clicking on a track in a playlist will show the track information and an option to remove the track from the playlist.

<img src="/pics/removeFromPlaylist.png" alt="Remove from playlist" width="200px"/>

**Delete a Playlist** 
Playlists can be deleted by clicking the remove button in the playlist view.

<img src="/pics/deletePlaylist.png" alt="Delete Playlist" width="200px"/>


