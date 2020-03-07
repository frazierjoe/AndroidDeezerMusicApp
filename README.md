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

**View Tracks**
Users can click on any track in the app to view track information and add the track to a playlist.

**Search for Artists**
Users can search for artsits and view all results in a grid recycler view.

**View Artists**
Users can click on an artist to view the artists name, image and a grid recyler view of their top tracks.

**View Playlsits**
Users can swipe between the top tracks view and a list of their playlists.

**Create Playlist**
Users can create a playlist by clicking to plus button to bring up a dialog box where the user can input playlist information.

**View a Playlist**
Playlists can be clicked to view playlist information and the tracks they contain.

**Delete a Track from a Playlist**
Clicking on a track in a playlist will show the track information and an option to remove the track from the playlist.

**Delete a Playlist** 
Playlists can be deleted by clicking the remove button in the playlist view.


