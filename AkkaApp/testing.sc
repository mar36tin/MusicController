val x = for {
  i <- 0 to 9
j <- 0 to 9
h <- 0 to 9
} yield {
  "martin" + h + j + i
}

x.length