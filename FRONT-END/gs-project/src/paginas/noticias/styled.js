// styled.js
import styled from "styled-components";

export const AreaNoticias = styled.div`
.background{
  background: rgb(61,107,11);
  background: linear-gradient(260deg, rgba(61,107,11,1) 16%, rgba(139,69,19,1) 75%);
}
a {
  text-decoration: none;
  transition: all 0.3s cubic-bezier(.25, .8, .25, 1);
}
div, h2, p, figure {
  margin: 0;
  padding: 0;
}

.header {
  color: white;
  padding: 40px 0 10px;
  text-align: center;
}

.header h1 {
  font-size: 40px;
  font-weight: bold;
  color: #fff;
  text-shadow: 2px 2px  #000000;
}

.main {
  margin: 0 auto;
  max-width: 1040px;
  padding: 10px;
  padding-bottom: 100px;
}

.column {
  flex: 1;
  flex-direction: column;
}

.article {
  background: #fff;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  color: green;
  display: flex;
  flex: 1;
  flex-direction: column;
  flex-basis: auto;
  margin: 10px;
}

.article:hover,
.article:focus {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
  color: #d4a707;
}

.article-image {
  background: #eee;
  display: block;
  padding-top: 75%;
  position: relative;
  width: 100%;
}

.article-image img {
  display: block;
  height: 100%;
  left: 0;
  position: absolute;
  top: 0;
  width: 100%;
}

.article-image.is-3by2 {
  padding-top: 66.6666%;
}

.article-image.is-16by9 {
  padding-top: 56.25%;
}

.article-body {
  display: flex;
  flex: 1;
  flex-direction: column;
  padding: 20px;
}

.article-title {
  flex-shrink: 0;
  font-size: 1.4em;
  font-weight: 700;
  line-height: 1.2;
}

.article-content {
  flex: 1;
  margin-top: 5px;
}

.article-info {
  display: flex;
  font-size: 0.85em;
  justify-content: space-between;
  margin-top: 10px;
}

@media screen and (min-width: 800px) {
  .columns,
  .column {
    display: flex;
  }
  section{
    padding: 0px;
  }
}

@media screen and (min-width: 1000px) {
  .first-article {
    flex-direction: row;
  }

  .first-article .article-body {
    flex: 1;
  }

  .first-article .article-image {
    height: 300px;
    order: 2;
    padding-top: 0;
    width: 400px;
  }

  .main-column {
    flex: 3;
  }

  .nested-column {
    flex: 2;
  }
}
`;
