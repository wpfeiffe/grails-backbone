<!DOCTYPE html>
<html>
<head>
  <title>Backbone Demo: Bookback</title>
  <meta name="layout" content="wsplayout">
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'screen.css')}" type="text/css">
  <script type="text/javascript" data-main="js/main" src="${resource(dir: 'js', file: 'require.js')}"></script>
</head>

<body>
<img src="${resource(dir: 'images', file: 'book.png')}" alt="Books"/>
<div id="books">
  <form id="addBook" action="#">
    <div>
      %{--<label for="coverImage">CoverImage:</label><input id="coverImage" type="file"/>--}%
      <label for="title">Title:</label><input id="title" type="text"/>
      <label for="author">Author:</label><input id="author" type="text"/>
      <label for="releaseDate">Release date:</label><input id="releaseDate" type="text" />
      <label for="keywords">Keywords:</label><input id="keywords" type="text"/>
      <button id="add">Add</button>
    </div>
  </form>
</div>

</body>
</html>