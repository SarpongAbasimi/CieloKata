package service

import model.Call

trait  Transformer[T] {
  def transform(stringData: Seq[String]): Seq[T]
}

object CallTransformer extends  Transformer[Call] {

  def transform(stringData: Seq[String]): Seq[Call]  = {
    stringData.map(splitter(_)).map(
      dataInArrayWithIndex => Call(dataInArrayWithIndex(0), dataInArrayWithIndex(1), dataInArrayWithIndex(2)))
  }

  private def splitter(callLog: String): Seq[String] = {
    callLog.split(" ")
  }
}
