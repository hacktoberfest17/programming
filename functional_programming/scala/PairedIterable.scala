import scala.language.implicitConversions

import scala.collection.mutable.HashMap
	
class PairedIterable[K, V](x: Iterable[(K, V)]) {
	def reduceByKey(func: (V,V) => V) = {
		val map: HashMap[K, V] = new HashMap[K, V]()
		x.foreach { pair =>
			map.get(pair._1) match {
				case None => map.put(pair._1, pair._2)
				case Some(thing) => map.put(pair._1, func(thing, pair._2))
			}
		}
		map
	}
	
	override def toString(): String = {	
		def toStringEl(y: Iterable[(K, V)]): String = {
			if(y.tail.isEmpty) y.head.toString
			else y.head.toString + ", " + toStringEl(y.tail)
		}
		
		"PairedIterable(" + toStringEl(x) + ")"
	}
}

object PairedIterable {
	implicit def iterableToPairedIterable[K, V](x: Iterable[(K, V)]) = { new PairedIterable(x) }
//	implicit def javaHashMapToPairedIterable[K, V](x: HashMap[K, V]) = { new PairedIterable(x.asScala) }
}

