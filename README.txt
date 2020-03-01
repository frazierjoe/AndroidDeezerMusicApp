In this file you should include:

Any information you think we should know about your submission
* Is there anything that doesn't work? Why?

* Is there anything that you did that you feel might be unclear? Explain it here.
Everything works and should be clear.

A description of the creative portion of the assignment
* Describe your feature
* Why did you choose this feature?
* How did you implement it?
For our creative portion we created a an artist and artist top tracks view.
To see this feature, search for an artist and then click on any of the results to open the artist view displaying the artist's name, image and their top 10 tracks.
We choose to implement this feature because the app seemed incomplete without allowing users to click on an artist and view information about them. 
To implement this feature, we added an onclick listener that distinguishes between artist and track objects then starts the corresponding activity when an item is clicked. The artist id is then passed to the artist activity where a http request is made to obtain the artist name and image. The activity also starts a fragment containing a recycler view that makes a http request for the artists top tracks which are then displayed in a grid below the artist's image.

